var sportBetting = {
    goToHrefOnClickRow: function (thisObj) {
        window.document.location = thisObj.children('td:first').data("href");
    },

    onBetTypeChange: function (thisObj) {
        let selectedOption = $('#selectedOption').children("option:selected");
        let text = selectedOption.val();
        let betIdSelectedOption = selectedOption.data("idoption")
        sportBetting.getContent("/outcome/" + betIdSelectedOption);
    },

    getContent: function (url) {
        $.ajax({
            url: url,
            dataType: "json",
            success: function (data) {
                if (data != null) {
                    window.alert(data);
                }
            },
            error: function (data) {
                window.alert("something go wrong, try again latter...")
            }
        })
    }
}