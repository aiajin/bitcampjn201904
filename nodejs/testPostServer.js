// 모듈 로드
// Http.Server
var http = require('http');

var server = http.createServer(function(req, res){
    
    // GET / POST 구분 
    var method = req.method.toLocaleLowerCase();
    console.log('request Method : ' + method);

    if(method == 'post'){
        console.log('post 요청일 때 처리');
    } else {
        console.log('get 요청일 때 처리');
    }


});

// 포트설정
server.listen(3000);