$(function () {
	var showProgressBar = function(JQuery){
		var progressBar = "<div class='spinner'></div>";
		JQuery.html(progressBar);
	}
	
	var loadContent = function(JQuery,href){
		showProgressBar(JQuery);
		JQuery.load( href, function( response, status, xhr ) {
			if (status=="success"){
				JQuery.html(response);
			}else{
				JQuery.html("<h2>"+"出错了: <br/>" + xhr.status + " " + xhr.statusText+"</h2>");
			}
		});
	}
	
	var loadTabContent = function (event) { //加载数据
		var currTab = $(event.target); // newly activated tab
//		var preTab = $(event.relatedTarget); // previous active tab
		var elementID = "#"+currTab.attr("aria-controls"); //内容元素的id
		var href = currTab.data("href");
		var tabContent = $(elementID);
		loadContent(tabContent,href);
	}

	var loadDeviceDetail = function (event) {
		var button = $(event.relatedTarget); // Button that triggered the modal
		var href = button.data("href");
		var modal = $(this);
		loadContent(modal,href);
	}

	//绑定加载数据
	$('a[data-toggle="tab"]').on('show.bs.tab',loadTabContent);
	$('#device-detail-modal').on('shown.bs.modal',loadDeviceDetail );

	//初始加载
	$('#nav a:first').tab('show');
})