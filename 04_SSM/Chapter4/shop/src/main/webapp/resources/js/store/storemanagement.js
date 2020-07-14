$(function() {
	var storeId = getQueryString('storeId');
	var storeInfoUrl = '/storeadmin/getstoremanagementinfo?storeId=' + storeId;
	$.getJSON(storeInfoUrl, function(data) {
		if (data.redirect) {
			window.location.href = data.url;
		} else {
			if (data.storeId != undefined && data.storeId != null) {
				storeId = data.storeId;
			}
			$('#storeInfo')
					.attr('href', '/storeadmin/storeoperation?storeId=' + storeId);
		}
	});
});