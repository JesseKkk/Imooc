$(function() {
	getlist();
	function getlist(e) {
		$.ajax({
			url : "/storeadmin/getstorelist",
			type : "get",
			dataType : "json",
			success : function(data) {
				if (data.success) {
					handleList(data.storeList);
					handleUser(data.user);
				}
			}
		});
	}
	function handleUser(data) {
		$('#user-name').text(data.name);
	}

	function handleList(data) {
		var html = '';
		data.map(function(item, index) {
			html += '<div class="row row-store"><div class="col-40">'
					+ item.storeName + '</div><div class="col-40">'
					+ storeStatus(item.enableStatus)
					+ '</div><div class="col-20">'
					+ gostore(item.enableStatus, item.storeId) + '</div></div>';

		});
		$('.store-wrap').html(html);
	}

	function storeStatus(status) {
		if (status == 0) {
			return '审核中';
		} else if (status == -1) {
			return '店铺非法';
		} else if (status == 1) {
			return '审核通过';
		}
	}

	function gostore(status, id) {
		if (status == 1) {
			return '<a href="/storeadmin/storemanagement?storeId=' + id
					+ '">进入</a>';
		} else {
			return '';
		}
	}
});