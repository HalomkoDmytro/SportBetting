var sportBetting = {
    goToHrefOnClickRow: function (thisObj) {
        window.document.location = thisObj.children('td:first').data("href");
    },

    onBetTypeChange: function (thisObj) {
        let selectedOption = $('#selectedOption').children("option:selected").val();
    }
}