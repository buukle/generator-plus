layui.use(['layer', 'form', 'element', 'jquery', 'dialog'], function() {
	var $ = layui.jquery;
	var element = layui.element;
	var hideBtn = $('#hideBtn');
	var mainLayout = $('#main-layout');
	var mainMask = $('.main-mask');

	element.on('tab', function(elem){
		let layId = $(this).attr('lay-id');
		let url = $('a[data-id|= "'+layId+'"]').attr('data-url');
		location.hash = "#"+url;
		var src=$(".layui-tab-item.layui-show").find("iframe").attr("src");
		$(".layui-tab-item.layui-show").find("iframe").attr("src",src);
	});

	//监听导航点击
	element.on('nav(leftNav)', function(elem){
		var id = elem.attr('data-id');
		var url = elem.attr('data-url');
		var text = elem.attr('data-text');
		if(!url){
			return;
		}
		location.hash = "#"+url;
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + getContextPath() + url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);

		}
		mainLayout.removeClass('hide-side');
	});
	//监听导航点击
	element.on('nav(rightNav)', function(elem) {
		var id = elem.attr('data-id');
		var url = elem.attr('data-url');
		var text = elem.attr('data-text');
		if(!url){
			return;
		}
		location.hash = "#"+url;
		var isActive = $('.main-layout-tab .layui-tab-title').find("li[lay-id=" + id + "]");
		if(isActive.length > 0) {
			//切换到选项卡
			element.tabChange('tab', id);
		} else {
			element.tabAdd('tab', {
				title: text,
				content: '<iframe src="' + getContextPath() +  url + '" name="iframe' + id + '" class="iframe" framborder="0" data-id="' + id + '" scrolling="auto" width="100%"  height="100%"></iframe>',
				id: id
			});
			element.tabChange('tab', id);

		}
		mainLayout.removeClass('hide-side');
	});
	//菜单隐藏显示
	hideBtn.on('click', function() {
		if(!mainLayout.hasClass('hide-side')) {
			mainLayout.addClass('hide-side');
			$(this).find('span').html('&#xe66b;')
		} else {
			mainLayout.removeClass('hide-side');
			$(this).find('span').html('&#xe668;')
		}
	});
	//遮罩点击隐藏
	mainMask.on('click', function() {
		mainLayout.removeClass('hide-side');
	})
});