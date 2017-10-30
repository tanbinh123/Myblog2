/**
 * Created by b1109_000 on 2017/10/22.
 */

    var width, height, lineheight, largeHeader = true;
    // Main
    function initHeader() {
        height = window.innerHeight;
        lineheight = (height - 435) / 2;
        largeHeader = document.getElementById('large-header');
        largeHeader.style.height = height + 'px';

        lineCaption = document.getElementById('line-caption');
        lineCaption.style.paddingTop = lineheight + 'px';
        }
$(function () {
    initHeader();
});
