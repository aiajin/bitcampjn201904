var fs = require('fs');
// 파일 위치 경로
var file = 'helloWorld.txt';
try {
    // 파일 존재 유무 확인
    fs.accessSync(file, fs.F_OK);
    console.log('파일 존재');
    // 파일 읽기
    fs.readFile(file, 'UTF-8',function(err, data){
        if(err){
            console.error('File Read Error :' + err);
            return;
        } 

        console.log('Read Text File UTF-8 Encoding');
        console.log(data);
    });
}
catch ( err ) {
    // 파일이 없을 때, 종료
    console.log('파일 존재하지 않음');
    process.exit(1);
}