define(['ojs/ojcore', 'knockout', 'ojs/ojtable'
], function (oj, ko) {
    function GeneratedContentViewModel() {
        var self = this;
        self.data = ko.observableArray();
        $.getJSON("http://localhost:8082/visitor-hibernate-2/rest/course/").
                then(function (courses) {
                    $.each(courses, function () {
                        self.data.push({
                            cname: this.cname,
                            cnotes: this.cnotes,
                        });
                    });
                });
        self.datasource = new oj.ArrayTableDataSource(
                self.data,
                {idAttribute: 'id'}
        );

    }
    return GeneratedContentViewModel;
});