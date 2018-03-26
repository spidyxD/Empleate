$(document).ready(function(){
    $('.parallax').parallax();
});

$('.carousel.carousel-slider').carousel({
fullWidth: true,
indicators: true
});
autoplay() //para hacer que el carrusel se mueva solo
function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 4500);
}

