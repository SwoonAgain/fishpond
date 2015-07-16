$(function () {
	showProgressBar = function(jQuery){
		var progressBar = "<div class='spinner'></div>";
		jQuery.html(progressBar);
	}

	//绑定选择事件,处理选择，反选，全选
	bindSelectEvent = function(){

		checked = function(checkbox){
			checkbox.removeClass("glyphicon-unchecked");
			checkbox.addClass("glyphicon-check");
		}
		unchecked = function(checkbox){
			checkbox.removeClass("glyphicon-check");
			checkbox.addClass("glyphicon-unchecked");
		}
		togglecheck = function(checkbox){
			checkbox.toggleClass("glyphicon-unchecked glyphicon-check");
		}

		$("#select-invert a").on("click",function(){
			var checkboies = $(this).parents("table").find("tbody tr th span");
			var allchecked = true;
			checkboies.each(function(index){
				var checkbox = $(this);
				togglecheck(checkbox);
				allchecked = allchecked&checkbox.hasClass("glyphicon-check");
			});
			var headcheckbox = $(this).parents("th").find(".glyphicon");
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
			var headcheckbox = $(this).parents("th").find(".glyphicon");
			checked(headcheckbox);
		});
		$("#deselect-all a").on("click",function(){
			var checkboies = $(this).parents("table").find("tbody tr th span");
			checkboies.each(function(index){
				var checkbox = $(this);
				unchecked(checkbox);
			});
			var headcheckbox = $(this).parents("th").find(".glyphicon");
			unchecked(headcheckbox);
		});

		//tablerow select
		$("tbody tr th").on("click",function(){
			var checkbox = $(this).find("span");
			togglecheck(checkbox);
			var checkboies = $(this).parents("table").find("tbody tr th span");
			var allchecked = true;
			checkboies.each(function(index){
				var checkbox = $(this);
				allchecked = allchecked&checkbox.hasClass("glyphicon-check");
			});
			var headcheckbox = $(this).parents("table").find("thead th .glyphicon");
			if(allchecked){
				checked(headcheckbox);
			}else{
				unchecked(headcheckbox);
			}
		});
	}

	//paging
	paging = function(data){
		var info = $.parseJSON(data);
		var onPage = info.onPage;
		var pageAmount = info.pageAmount;
		var pagingul = $("#paging ul");
		onPage = parseInt(onPage);
		pageAmount = parseInt(pageAmount);
		var previousButton = $("#paging ul li:first");
		var nextButton = $("#paging ul li:last");
		if(onPage == 1){
			previousButton.addClass("disabled");
		}else{
			previousButton.find("a .sr-only").html(onPage-1);
			previousButton.removeClass("disabled");
		}
		if(onPage == pageAmount){
			nextButton.addClass("disabled");
		}else{
			nextButton.find("a .sr-only").html(onPage+1);
			nextButton.removeClass("disabled");
		}
		pagingul.empty();
		pagingul.append(previousButton);

		var inflatePaging = function(begin,end){
			for(var i = begin; i <= end;i++ ){
				var clazz =  i==onPage?" class= 'active' ":"";
				var li = "<li"+clazz+"><a href='#'>"+ i +"<span class='sr-only'>"+ i +"</span></a></li>";
				pagingul.append(li);
			}
		}
		if (pageAmount <= 5) {
			inflatePaging(1,pageAmount);
		}else if(onPage <= 3){
			inflatePaging(1,5);
		}else if((pageAmount - onPage) < 2){
			inflatePaging(pageAmount - 4,pageAmount);
		}else{
			inflatePaging(onPage -2,onPage +2);
		}
		pagingul.append(nextButton);
		//binding page event
		//binding page event
		pagingul.find("li").on("click",function(){
			var li = $(this);
			if (li.hasClass("active")||li.hasClass("disabled")) {
				return;
			}else{
				var page = li.find(".sr-only").html();
				lego.urlbase = lego.urlbase.substring(0,lego.urlbase.length-2)+page+"/";
				updateTable(li);
			}
		});
	}

	bindSortEvent = function(){
		//bind
		$("#sort ul li a").on("click",function(){
			var sort = $(this).data("field");
			if (lego.sort == sort) {
				lego.sort = sort+"Desc";
			}else{
				lego.sort = sort;
			}
			$("#sort button span:first").html($(this).html()); //更新按钮文字
			$("#sort button").data("field",sort);
			updateTable($(this));
		});
	}

	lego = {};
	initLego = function(){
		var tabhref = $("#nav ul .active a").data("href");
		lego.urlbase=tabhref.substring(0,tabhref.length-1)+"table/1/";
		var sort = $("#sort button").data("field");
		var filter = $("#filter button").data("field");
		var value = $("#filter input").val();
		lego.sort = sort;
		lego.filter = filter;
		lego.value = value;
	}

	bindFilterEvent = function(){
		$("#filter ul li a").on("click",function(){
			var filter = $(this).data("field");
			lego.filter = filter;
			$("#filter button span:first").html($(this).html()); //更新按钮文字
			$("#filter button").data("field",sort);
			if (filter == "") {
				$("#filter input").attr("disabled","");
				$("#filter input").val("");
				lego.value = "";
				$("#filter #submit").attr("disabled","");
				updateTable($(this));
			}else{
				$("#filter input").removeAttr("disabled");
				$("#filter #submit").removeAttr("disabled");
			}
		});
		$("#filter #submit").on("click",function(){
			lego.value = $("#filter input").val();
			updateTable($(this));
		});
	}

	updatePaging = function(){
		try{
			$.get( lego.urlbase+"update-page-amount")
			.done(function( data ) {
				paging(data);
			});
		}catch(e){
			console.log(e);
		}
	}

	updateTable = function(jQuery){
		var url = lego.urlbase+"?sort="+lego.sort+"&filter="+lego.filter+"&value="+lego.value;
		var devicesList = jQuery.parents(".tab-pane").find("#devices-list");
		showProgressBar(devicesList);
		devicesList.load( url, function( response, status, xhr ) {
			if (status=="success"){
				devicesList.html(response);
				bindSelectEvent();
				//更新分页
				updatePaging();
			}else{
				jQuery.html("<h2>"+"出错了: <br/>" + xhr.status + " " + xhr.statusText+"</h2>");
			}
		});
	}

	loadTabContent = function (event) { //加载数据
		var currTab = $(event.target); // newly activated tab
		var preTab = $(event.relatedTarget); // previous active tab
		var elementID = "#"+currTab.attr("aria-controls"); //内容元素的id
		var preElementID = "#"+preTab.attr("aria-controls"); 
		$(preElementID).empty();
		var href = currTab.data("href");
		var tabContent = $(elementID);
		showProgressBar(tabContent);
		tabContent.load( href, function( response, status, xhr ) {
			if (status=="success"){
				tabContent.html(response);
				if(elementID == "#list-online" || elementID == "#list-all"){
					initLego();
					bindSelectEvent();
					updatePaging();
					bindSortEvent();
					bindFilterEvent();
				}
			}else{
				jQuery.html("<h2>"+"远程服务器没有响应: <br/>" + xhr.status + " " + xhr.statusText+"</h2>");
			}
		});
	}

	loadModal = function(modal,href){
		showProgressBar(modal);
		modal.load( href, function( response, status, xhr ) {
			if (status=="success"){
				modal.html(response);
				$('#device-detail ul li a').on('shown.bs.tab', function (event) {
					var currTab = $(event.target); // newly activated tab
					var elementID = "#"+currTab.attr("aria-controls"); //内容元素的id
					var tabContent = $(elementID);
					if(tabContent.is("#device-parameters")){
						inputs = tabContent.find("input");
						inputs.attr("disabled","");
						var modalFooter = tabContent.parents(".modal-content").find(".modal-footer");
						modalFooter.find(".btn-primary").removeClass("hidden");
						modalFooter.find("#modal-edit").on("click",function(){
							inputs.removeAttr("disabled");
						});
						var saveButton = modalFooter.find("#modal-save");
						//parameters form submit action
						saveButton.on("click",function(){
							$("#edit-parameters").submit(function(e){
								var formObj = $(this);
								var formURL = formObj.attr("action");
								var formData = $(this).serializeArray();
								$.ajax({
									url: formURL,
									type: 'POST',
									data:  formData,
									success: function(data, textStatus, jqXHR){
										if (data == true) {
											saveButton.html("保存成功!");
											saveButton.removeClass("btn-primary");
											saveButton.addClass("btn-success");
										}else{
											alert("写入失败，请确定数据无误重试。");
											saveButton.html("保存");
											saveButton.removeClass("btn-primary");
										}
									},
									error: function(jqXHR, textStatus, errorThrown) {
										alert("发生未知错误，请刷新页面重试。");
										saveButton.html("保存");
									}          
								});
								e.preventDefault(); //STOP default action
							}); 
							$("#edit-parameters").submit(); //Submit the form
							saveButton.html("正在保存...");
							saveButton.attr("disabled","");
						});
					}
					if(tabContent.is("#device-work-status")){
						var modalFooter = tabContent.parents(".modal-content").find(".modal-footer");
						modalFooter.find(".btn-primary").addClass("hidden");
					}
				});
			}else{
				jQuery.html("<h2>"+"远程服务器没有响应: <br/>" + xhr.status + " " + xhr.statusText+"</h2>");
			}
		});
	}

	loadDeviceDetail = function (event) {
		var button = $(event.relatedTarget); // Button that triggered the modal
		var href = button.data("href");
		var modal = $(this);
		loadModal(modal,href);
	}

	//绑定加载数据
	$('#nav ul li a').on('show.bs.tab',loadTabContent);
	$('#device-detail-modal').on('show.bs.modal',loadDeviceDetail );

	//初始加载
	$('#nav a:first').tab('show');


})