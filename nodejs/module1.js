module.exports.hi = function(){
    console.log('hi~');
}
exports.bye = function(){
    console.log('bye~');
}
function Member(name) {
    this.name = name;
    this.say = function(){
        console.log('hi~ ' + name);
    }
}
module.exports.Member = Member;
module.exports = Member;