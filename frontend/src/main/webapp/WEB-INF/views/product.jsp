<div class="container">
	<div class="row">
		

		<div class="col-md-12">

			<c:if test="${userClickProduct==true}">
				<script>
					window.categoryId ='';
				</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page"><a
						href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item " aria-current="page">All Products</li>
				</ol>
			</c:if>
			<c:if test="${userClickCategoryProduct==true}">
				<script>
					window.categoryId ='${category.id}';
				</script>
				<ol class="breadcrumb">
					<li class="breadcrumb-item active" aria-current="page"><a
						href="${contextRoot}/home">Home</a></li>
					<li class="breadcrumb-item " aria-current="page">Category</li>
					<li class="breadcrumb-item " aria-current="page">${category.name}</li>
				</ol>
			</c:if>

			<div class="row">
				<div class="col-xl-12">
					<table id="userDataTable"
						class="table table-striped table-bordered">
						<thead>
							<tr>
								<th id="new-list"></th>
								<th id="new-list">Name</th>
								<th id="new-list">Brand</th>
								<th id="new-list">unitPrice</th>
								<th id="new-list">Quantity</th>
								<th id="new-list"></th>
								
							</tr>

						</thead>
						<tfoot>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Brand</th>
								<th>unitPrice</th>
								<th>Quantity</th>
								<th></th>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>