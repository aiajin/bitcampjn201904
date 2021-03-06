// 모듈 로드
// express
var express = require('express');

// 서버 객체 생성
var app = express();

app.use(function(req, res, next){
    var now = new Date();
    console.log(now.toDateString() + ' : ' + req.method + ' : ' + req.url);
    // 시간 : get : /teset
    next();    
});

app.use(function(req, res){
    res.send('hello~ express');
});

// app.get('/v1/movies', movieList);
// app.post('/v1/movies', movieCreate);
// app.put('/v1/movies/1', movieEdit);

app.listen(3000);

function movieList(){
    console.log('movieList');
}
function movieCreate(){
    console.log('movieCreate');
}
function movieEdit(){
    console.log('movieEdit');
}

