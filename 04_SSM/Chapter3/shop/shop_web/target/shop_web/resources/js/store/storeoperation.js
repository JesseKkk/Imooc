$(function () {
    var storeId = getQueryString('storeId');
    var isEdit = storeId ? true:false;
    var initUrl = '/storeadmin/getstoreinitinfo';
    var registerStoreUrl = '/storeadmin/registerstore';
    var storeInfoUrl = '/storeadmin/getstorebyid?storeId=' + storeId;
    var editStoreUrl = '/storeadmin/modifystore';
    if (!isEdit) {
        getStoreInitInfo();
    } else {
        getStoreInfo(storeId);
    }
    function getStoreInfo(storeId) {
        $.getJSON(storeInfoUrl, function(data) {
            if (data.success) {
                // 若访问成功，则依据后台传递过来的店铺信息为表单元素赋值
                var store = data.store;
                $('#store-name').val(store.storeName);
                $('#store-addr').val(store.storeAddr);
                $('#store-phone').val(store.phone);
                $('#store-desc').val(store.storeDesc);
                // 给店铺类别选定原先的店铺类别值
                var storeCategory = '<option data-id="'
                    + store.storeCategory.storeCategoryId + '" selected>'
                    + store.storeCategory.storeCategoryName + '</option>';
                var tempAreaHtml = '';
                // 初始化区域列表
                data.areaList.map(function(item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                });
                $('#store-category').html(storeCategory);
                // 不允许选择店铺类别
                $('#store-category').attr('disabled', 'disabled');
                $('#area').html(tempAreaHtml);
                // 给店铺选定原先的所属的区域
                $("#area option[data-id='" + store.area.areaId + "']").attr(
                    "selected", "selected");
            }
        });
    }
    
    function getStoreInitInfo() {
        $.getJSON(initUrl,function(data) {
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.storeCategoryList.map(function(item, index) {
                    tempHtml += '<option data-id="' + item.storeCategoryId + '">'
                    + item.storeCategoryName + '</option>';
                })
                data.areaList.map(function (item, index) {
                    tempAreaHtml+= '<option data-id="' + item.areaId + '">'
                        + item.areaName + '</option>';
                })
                $('#store-category').html(tempHtml);

                $('#area').html(tempAreaHtml);
            }
        });
    }
    $('#submit').click(function () {
        var store = {};
        if (isEdit){
            store.storeId = storeId;
        }
        store.storeName = $('#store-name').val();
        store.storeAddr = $('#store-addr').val();
        store.phone = $('#store-phone').val();
        store.storeDesc = $('#store-desc').val();
        store.storeCategory = {
            storeCategoryId: $('#store-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        store.area = {
            areaId: $('#area').find('option').not(function () {
                return !this.selected;
            }).data('id')
        }
        var storeImg = $('#store-img')[0].files[0];
        var formData = new FormData();
        formData.append('storeImg', storeImg);
        formData.append('storeStr', JSON.stringify(store));
        var verifyCodeActual = $('#j_captcha').val();
        if (!verifyCodeActual){
            $.toast('请输入验证码！');
            return;
        }
        formData.append('verifyCodeActual', verifyCodeActual);
        $.ajax({
            url : (isEdit?editStoreUrl:registerStoreUrl),
            type : 'POST',
            data : formData,
            contentType : false,
            processData: false,
            cache : false,
            success : function (data) {
                if (data.success) {
                    $.toast('提交成功');
                } else {
                    $.toast('提交失败！' + data.errMsg);
                }
                $('#captcha_img').click();
            }
        })
    })
})