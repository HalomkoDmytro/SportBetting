var sportBetting = {
    goToHrefOnClickRow: function (thisObj) {
        window.document.location = thisObj.children('td:first').data("href");
    },

    onBetTypeChange: function (thisObj) {
        let selectedOption = $('#selectedOption').children("option:selected");
        // let text = selectedOption.val();
        let betIdSelectedOption = selectedOption.data("idoption")
        sportBetting.getContent("/outcome/" + betIdSelectedOption);
    },

    getContent: function (url) {
        $.ajax({
            url: url,
            type: "GET",
            contentType: "application/json",
            dataType: "json",
            cache: false,
            timeout: 600000,
            success: function (json) {
                sportBetting.populateDropDown(json);
            },
            error: function (data) {
                window.alert("something go wrong, try again latter...")
            }
        })
    },

    populateDropDown: function (json) {
        let outcomeOptionBox = $('#selectOutcomeOption');
        let outcomeOptionBlock = $('#outcomeOptionBlock');
        outcomeOptionBox.empty();

        if (json.length !== 0) {
            outcomeOptionBlock.css('visibility', 'visible');
            $.each(json, function (i, value) {
                outcomeOptionBox.append($('<option></option>')
                    .attr('value', value.id)
                    .text(value.value));
            })
        } else {
            outcomeOptionBlock.css('visibility', 'hidden');
        }
    }
};