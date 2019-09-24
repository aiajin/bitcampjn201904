var pathUtil = require('path');
// 경로 분석
var path = '/foo/bar/baz/asdf/quux.html';
// /foo/bar/baz/asdf
console.log('dirname : ', pathUtil.dirname(path));
// quux.html
console.log('basename : ', pathUtil.basename(path));
// .html
console.log('extname : ', pathUtil.extname(path));