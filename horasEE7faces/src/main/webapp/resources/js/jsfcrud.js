function handleSubmit(args, dialog) {
    console.log("en funcion handleSubmit");
      console.log(args);
      console.log(dialog);
      console.log(jQuery);
    var jqDialog = jQuery('#' + dialog);
    if (args.validationFailed) {
        jqDialog.effect('shake', {times: 3}, 100);
    } else {
        PF(dialog).hide();
    }
}
