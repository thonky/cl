/**
 * 该JS是将对ligerUI的操作统一集成在一起，引入该文件前，必须要引入ligerUI相应的JS <script
 * src="../../lib/ligerUI/js/core/base.js" type="text/javascript"></script>
 * <script src="../../lib/ligerUI/js/plugins/ligerDrag.js"
 * type="text/javascript"></script> <script
 * src="../../lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
 * <link href="../../lib/ligerUI/skins/Aqua/css/ligerui-all.css"
 * rel="stylesheet" type="text/css" />
 * 
 * @type
 */
var TkDialog = {
	// 成功提示框
	success : function(msg) {
		$.ligerDialog.success(msg);
	},
	// 警告提示框
	warn : function(msg) {
		$.ligerDialog.warn(msg);
	},
	// 错误提示框
	error : function(msg) {
		$.ligerDialog.error(msg);
	},
	// 确认框
	confirm : function(msg, callback) {
		$.ligerDialog.confirm(msg, callback);
	},
	// 弹出等待框
	popWaitting : function(msg) {
		if (!msg)
			msg = "正在保存中,请稍候...";
		$.ligerDialog.waitting(msg);
	},
	// 关闭等待框
	closeWaitting : function(msg) {
		$.ligerDialog.closeWaitting();
	},
	// 提示框
	alert : function(info, type, typecode, callback) {
		$.ligerDialog.alert(info, type, typecode, callback);
	},
	// 弹出窗口
	openWindow : function(configObj) {
		if (configObj) {
			if (!configObj.buttons) {
				configObj.buttons = [ {
					text : '关闭',
					onclick : function(item, dialog) {
						dialog.close();
					}
				} ];
			}
			var infoWin = $.ligerDialog.open(configObj);
			if (configObj.close) {
				$(".l-dialog-close").bind('mousedown', function(event)// dialog右上角的叉
				{
					configObj.close(infoWin);
					// 关闭窗口
					infoWin.close();
				});
			}
		}
	},
	openAndReturn : function(configObj) {
		if (configObj) {
			if (!configObj.buttons) {
				configObj.buttons = [ {
					text : '关闭',
					onclick : function(item, dialog) {
						dialog.close();
					}
				} ];
			}
			var infoWin = $.ligerDialog.open(configObj);
			if (configObj.close) {
				$(".l-dialog-close").bind('mousedown', function(event)// dialog右上角的叉
				{
					configObj.close(infoWin);
					// 关闭窗口
					infoWin.close();
				});
			}
		}
		return infoWin;
	}
}