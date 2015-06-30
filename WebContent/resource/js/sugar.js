$(function () {
	var showProgressBar = function(jQuery){
		var progressBar = "<div class='spinner'></div>";
		jQuery.html(progressBar);
	}

	var loadContent = function(jQuery,href,callback){
		showProgressBar(jQuery);
		jQuery.load( href, function( response, status, xhr ) {
			if (status=="success"){
				jQuery.html(response);
				if(callback != null){
					callback();
				}
			}else{
				jQuery.html("<h2>"+"出错了: <br/>" + xhr.status + " " + xhr.statusText+"</h2>");
			}
		});
	}

	var toogleTableRow = function(jQueryRow){
		var checkbox = jQueryRow.find("th span .glyphicon");
		checkbox.toggleClass("glyphicon-unchecked glyphicon-check");
	}

	var loadTabContent = function (event) { //加载数据
		var currTab = $(event.target); // newly activated tab
//		var preTab = $(event.relatedTarget); // previous active tab
		var elementID = "#"+currTab.attr("aria-controls"); //内容元素的id
		var href = currTab.data("href");
		var tabContent = $(elementID);
		loadContent(tabContent,href,tableCheckboxCallback);
	}

	var loadDeviceDetail = function (event) {
		var button = $(event.relatedTarget); // Button that triggered the modal
		var href = button.data("href");
		var modal = $(this);
		loadContent(modal,href);
	}

	/**
	 *处理选择，反选，全选等 
	 */
	var tableCheckboxCallback = function(){
		var checked = function(checkbox){
			checkbox.removeClass("glyphicon-unchecked");
			checkbox.addClass("glyphicon-check");
		}
		var unchecked = function(checkbox){
			checkbox.removeClass("glyphicon-check");
			checkbox.addClass("glyphicon-unchecked");
		}
		//绑定选择事件
		$("#select-invert a").on("click",function(){
			var checkboies = $(this).parents("table").find("tbody tr th span");
			var allchecked = true;
			checkboies.each(function(index){
				var checkbox = $(this);
				checkbox.toggleClass("glyphicon-unchecked glyphicon-check");
				allchecked = allchecked&checkbox.hasClass("glyphicon-check");
			});
			var headcheckbox = $(this).parents("th").find("glyphicon");
			if(allchecked){
				checked(headcheckbox);
			}else{
				unchecked(headcheckbox);
			}
		});
		$("#select-all a").on("click",function(){
			var checkboies = $(this).parents("table").find("tbody tr th span");
			checkboies.each(function(index){
				var checkbox = $(this);
				checked(checkbox);
			});
			var headcheckbox = $(this).parents("th").find("glyphicon");
			checked(headcheckbox);
		});
		$("#deselect-all a").on("click",function(){
			var checkboies = $(this).parents("table").find("tbody tr th span");
			checkboies.each(function(index){
				var checkbox = $(this);
				unchecked(checkbox);
			});
			var headcheckbox = $(this).parents("th").find("glyphicon");
			unchecked(headcheckbox);
		});
	}

	//绑定加载数据
	$('a[data-toggle="tab"]').on('show.bs.tab',loadTabContent);
	$('#device-detail-modal').on('show.bs.modal',loadDeviceDetail );

	//初始加载
	$('#nav a:first').tab('show');
})