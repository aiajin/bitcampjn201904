// 모듈 로드
// Http.Server
var http = require('http');
var querystring = require('querystring');
var fs = require('fs');
var formidable = require('formidable');
var pathUtil = require('path');


// 데이터 
var movieList = [
    { 
        title: '스타워즈', 
        director: '조지루카스', 
        image: 'images/starwars.jpg' 
    }
];

// images 경로
var imgDirPath = __dirname + '/images';



var server = http.createServer(function (req, res) {

    var url = req.url;
    var method = req.method.toLocaleLowerCase();

    if(url == '/' && method == 'get') {

        list(req, res);

    } else if(url.indexOf('/images/') == 0 && method == 'get') {
        var  urlPath = __dirname + req.url ;  // /images/starwars.jpg

        res.writeHead(200, {'Content-Type' : 'image/jpg'});
        fs.createReadStream(urlPath).pipe(res);
    } else if(url == '/' && method == 'post'){
        addNewMovie(req, res);
    }





    // GET / POST 구분 
    // var method = req.method.toLocaleLowerCase();
    // console.log('request Method : ' + method);

    // if (method == 'post') {
    //     console.log('post 요청일 때 처리');
    //     addMovie(req, res);
    // } else {
    //     console.log('get 요청일 때 처리');
    //     list(req, res);
    // }



});

// 포트설정
server.listen(3000);

function addNewMovie(req, res){

    var form = formidable.IncomingForm();
    form.uploadDir = imgDirPath;

    form.parse(req, function(err, fields, files){

        var title = fields.title;
        var director = fields.director;
        var posterImg = files.poster;

        var date = new Date();

        var newFileName = 'poster_'+date.getHours()+date.getMinutes+date.getSeconds;

        var ext = pathUtil.parse(posterImg.name).ext;

        var newPath = __dirname + newFileName + ext;

        fs.renameSync(posterImg.path, newPath);

        var newPosterImgUrl = 'images/'+newFileName+ext;

        var mInfo = {
            title : title ,
            director : director,
            image : newPosterImgUrl
        };

        movieList.push(mInfo);
        
        res.statusCode = 302;
        res.setHeader('Location', '.');
        res.end('success');


    });

}



function addMovie(req, res) {

    console.log('addMovie');
    // res 의 'data' / 'end' 이벤트를 이용해서 body의 내용을 읽어 처리한다.

    var body = '';

    req.on('data', function (chunk) {
        body += chunk;
        console.log('body : ' + body);
    });

    req.on('end', function () {

        var parsedData = querystring.parse(body);

        console.log('parsed : ' , parsedData);

        movieList.push({title : parsedData.title, director : parsedData.director});

        //list(req, res);

        
        res.statusCode = 302;
        res.setHeader('Location', '.');
        res.end('success');



    });


}


function list(req, res) {
    // movieList 데이터를 출력해서 보여주는 html
    // 해더 설정
    res.writeHeader(200, { 'Content-Type': 'text/html; charset=UTF-8' });

    // body 설정
    res.write('<html>');
    res.write('<meta charset="UTF-8">');
    res.write('<body>');
    res.write('<h3>Favorite Movie</h3>');
    res.write('<div><ul>');

    movieList.forEach(function (item) {
        res.write('<li><img src="'+ item.image +'" height="50">' + item.title + '(' + item.director + ')' + '</li>')
    });

    res.write('</ul></div>');
    res.write(
        '<form method="post" enctype="multipart/form-data" ><h4>새 영화 입력</h4>' +
        '<div><input type="text" name="title" placeholder="영화제목"></div>' +
        '<div><input type="text" name="director" placeholder="감독"></div>' +
        '<div><input type="file" name="poster"></div>' +
        '<input type="submit" value="upload">' +
        '</form>'
    );
    res.write('</body>');
    res.write('</html>');

    // 응답실행
    res.end();

}