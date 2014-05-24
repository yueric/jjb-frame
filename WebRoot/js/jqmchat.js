$(function () {
    //var content = $('#content');
    var chat_content = $('#chatlist');
    var user_content = $('#userlist');
    var status = $('#status');
    var input = $('#input');
    var myName = false;

    //建立websocket连接
    socket = io.connect('http://192.168.11.6:3000');
    //第一次传入用户名字信息
    socket.send('eric');

    //收到server的连接确认
    socket.on('open',function(){
        status.text('Choose a name:');
    });

    //监听system事件，判断welcome或者disconnect，打印系统消息信息
    socket.on('system',function(json){
        var p = '';
        if (json.type === 'welcome'){
            if(myName==json.text) status.text(myName + ': ').css('color', json.color);
            p = '<li><p style="background:'+json.color+'">system  @ '+ json.time+ ' : Welcome ' + json.text +'</p></li>';
        }else if(json.type == 'disconnect'){
            p = '<li><p style="background:'+json.color+'">system  @ '+ json.time+ ' : Bye ' + json.text +'</p></li>';
        }
        chat_content.prepend(p);
    });

    //监听message事件，打印消息信息
    socket.on('message',function(json){
        var p = '<li><p><span style="color:'+json.color+';">' + json.author+'</span> @ '+ json.time+ ' : '+json.text+'</p></li>';
        chat_content.prepend(p);
    });

    //通过“回车”提交聊天信息
    input.keydown(function(e) {
        if (e.keyCode === 13) {
            var msg = $(this).val();
            if (!msg) return;
            socket.send(msg);
            $(this).val('');
            if (myName === false) {
                myName = msg;
            }
        }
    });
});