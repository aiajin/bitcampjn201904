var fs = require('fs');

var path = 'textData.txt';

fs.appendFile(path, '\n Additional data', function(err) {
    if ( err ) {
        console.error('파일 내용 추가 실패 : ', err);
    }
    console.log('파일 내용 추가 성공');
});


// fs.writeFile('textData.txt', 'Hello World123', function(err) {
//     if ( err ) {
//         console.error('파일 저장 실패 : ', err);
//         return;
//     }
//     console.log('파일 저장 성공');
// });