/**
 * Created by manoj on 12/29/15.
 */
/*$(document).ready(function() {
    $("html,body").animate({scrollTop: 0}, 100); //100ms for example
});
window.onload = function() {
    setTimeout (function () {
        scrollTo(0,0);
    }, 100); //100ms for example
}*/

function showPassword() {

    var key_attr = $('#key').attr('type');

    if(key_attr != 'text') {

        $('.checkbox').addClass('show');
        $('#key').attr('type', 'text');

    } else {

        $('.checkbox').removeClass('show');
        $('#key').attr('type', 'password');

    }

};