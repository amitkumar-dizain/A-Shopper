<div
	class="row align-items-center bg-light py-3 px-xl-5 d-none d-lg-flex">
	<div class="col-lg-4">
		<a href="" class="text-decoration-none"> <span
			class="h1 text-uppercase text-light bg-dark px-2">A</span> <span
			class="h1 text-uppercase text-dark bg-light px-2 ml-n1">Shopper</span>
		</a>
	</div>
	<div class="col-lg-4 col-6 text-left">
		<form action="">
			<div class="input-group">
				<input type="text" class="form-control"
					placeholder="Search for products">
				<div class="input-group-append">
					<span class="input-group-text bg-transparent text-dark"> <i
						class="fa fa-search"></i>
					</span>
				</div>
			</div>
		</form>
	</div>
	<div class="col-lg-4 col-6 text-right">
		<p class="m-0">Customer Service</p>
		<h5 class="m-0">444 564 700</h5>
	</div>
</div>

<div class="container-fluid bg-dark mb-30">
	<div class="row px-xl-5">

		<div class="col-lg-3 d-none d-lg-block">

			<a
				class="btn d-flex align-items-center justify-content-between bg-secondary w-80"
				data-toggle="collapse" href="#navbar-vertical"
				style="height: 65px; padding: 0 30px;">
				<h4 class="text-dark m-0">Categories</h4> <i
				class="fa fa-angle-down text-dark"></i>
			</a>
			<nav
				class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 bg-light"
				id="navbar-vertical" style="width: calc(100% - 30px); z-index: 999;">
				<div class="navbar-nav w-100">
					<c:forEach var="category" items="${categories}">
						<a href="${contextRoot}/show/category/${category.id}/products"
							class="nav-item nav-link">${category.name}</a>
					</c:forEach>
				</div>
			</nav>
		</div>
		<div class="col-lg-9">
			<nav
				class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">

				<div class="collapse navbar-collapse justify-content-between"
					id="navbarCollapse">
					<div class="navbar-nav mr-auto py-0">
						<a href="${contextRoot}/home" class="nav-item nav-link ">Home</a>
						<a href="${contextRoot}/all/products" class="nav-item nav-link">Products</a>

						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown">Pages <i
								class="fa fa-angle-down mt-1"></i></a>
							<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
								<a href="${contextRoot}/cart" class="dropdown-item">Shopping Cart</a> <a
									href="${contextRoot}/checkout" class="dropdown-item">Checkout</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-toggle="dropdown">Admin <i class="fa fa-angle-down mt-1"></i></a>
							<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
								<a href="${contextRoot}/manage/product" class="dropdown-item">Manage
									Product</a>

							</div>
						</div>
						<a href="${contextRoot}/about" class="nav-item nav-link">About</a>
						<a href="${contextRoot}/contact" class="nav-item nav-link">Contact</a>

					</div>
					<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
						<a href="" class="btn px-0"> <i
							class="fas fa-heart text-light"></i> <span
							class="badge text-secondary border border-secondary rounded-circle"
							style="padding-bottom: 2px;">0</span>
						</a> <a href="" class="btn px-0 ml-3"> <i
							class="fas fa-shopping-cart text-light"></i> <span
							class="badge text-secondary border border-secondary rounded-circle"
							style="padding-bottom: 2px;">0</span>
						</a>
					</div>
				</div>
			</nav>
		</div>
	</div>
</div>