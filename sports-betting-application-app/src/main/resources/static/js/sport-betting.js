var sportBetting = {
    goToHrefOnClickRow: function (thisObj) {
        window.document.location = thisObj.children('td:first').data("href");
    }
}