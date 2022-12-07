$(function() {
	var $table = $('#userDataTable');

	if ($table.length) {
		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		}
		else {
			jsonUrl = window.contextRoot + '/json/data/category/'
				+ window.categoryId + '/products';
		}

		$table.DataTable({
			lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All Records']],
			pageLength: 4,
			ajax: {
				url: jsonUrl,
				dataSrc:''
			},
			columns: [

				{
					data: 'code',
					mRender: function(data, type, row) {

						return '<img src="' + window.contextRoot + '/xyz/images/' + data + '.jpg" class="dataTableImg"/>';
					}

				},

				{
					bSortable: false,
					data: 'name'
				},
				{
					data: 'brand'
				},
				{
					data: 'unitPrice',
					mRender: function(data, type, row) {
						return '&#8377;' + data;
					}

				},
				{
					data: 'quantity',
					mRender: function(data, type, row) {
						if (data < 1) {
							return '<span style="color:red">Out Of Stock Guys !!</span>';
						}
						return data;
					}

				},
				{
					data: 'id',
					mRender: function(data, type, row) {
						var str = '';
						str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a>';
						if (row.quantity < 1) {
							str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
						}
						else {
							str += '<a href="' + window.contextRoot + '/add/cart/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

						}


						return str;
					}

				}

			],
			"initComplete": function(settings, json) {
				// show new container for data
				$('#new-list').insertBefore('#userDataTable');
				$('#new-list').show();
			},
			"rowCallback": function(row, data) {
				// on each row callback
				var li = $(document.createElement('li'));

				for (var i = 0; i < data.length; i++) {
					li.append('<p>' + data[i] + '</p>');
				}
				li.appendTo('#new-list');
			},
			"preDrawCallback": function(settings) {
				// clear list before draw
				$('#new-list').empty();
			}


		});

	}


	$alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

});