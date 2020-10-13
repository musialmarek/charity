$(function () {
    const $city = $('#city');
    const $street = $('#street');
    const $zipCode = $('#zip-code');
    const $date = $('#date');
    const $time = $('#time');
    const $comment = $('#comment');
    const $organization = $('#organization');
    const $categories = $('#categories');
    const $phone = $('#phone');
    const $quantity = $('#quantity');
    const $summaryButton = $('#to-summary');

    const setCity = function () {
        console.log("setting city");
        $('#summary-city').text($city.val())
    };
    const setStreet = function () {
        console.log("setting street");
        $('#summary-street').text($street.val())
    };
    const setZipCode = function () {
        console.log("setting zip code");
        $('#summary-zipcode').text($zipCode.val())
    };
    const setDate = function () {
        console.log("setting date");
        $('#summary-date').text($date.val())
    };
    const setTime = function () {
        console.log("setting time");
        $('#summary-time').text($time.val())
    };
    const setComment = function () {
        console.log("setting comment");
        $('#summary-comment').text($comment.val())
    };
    const setPhone = function () {
        console.log("setting phone");
        $('#summary-phone').text($phone.val())
    };
    const setQuantity = function () {
        console.log("setting quantity");
        $('#summary-quantity').text($quantity.val())
    };
    const setOrganization = function () {
        console.log("setting organization");
        const $checkedOrganization = $('#organizations input:checked');
        $('#summary-organization').text($checkedOrganization.attr('title'))
    };
    const setCategories = function () {
        console.log("setting categories");
        const $checkedCategories = $('#categories-checkboxes input:checked');
        const $summaryCategories = $('#summary-categories');
        $summaryCategories.text(null);
        $checkedCategories.each(function () {
            const $title = $(this).attr('title');
            console.log("category  " + $title);
            $summaryCategories.text(`${$summaryCategories.text()} ${$title}, `)
        })
    };
    $summaryButton.click(function () {
        setCity();
        setStreet();
        setZipCode();
        setCategories();
        setComment();
        setDate();
        setTime();
        setOrganization();
        setPhone();
        setQuantity();
    })

});