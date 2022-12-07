<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">

	<c:if test="${not empty message}">
		<div class="row">
			<div class="col-md-offset-2 col-md-8">
				<div class="alert alert-info fade in">${message}</div>
			</div>
		</div>
	</c:if>


	<div class="row">

		<div class="col-md-offset-2 col-md-8 ">
			<div class="panel panel-primary">

				<div class="panel-heading">
					<h3>Product Management</h3>
				</div>
				<div class="panel-body">
					<sf:form action="${contextRoot}/manage/product" method="POST"
						modelAttribute="product" class="form-horizontal">

						<div class="form-group">
							<label class="contol-label col-md-4">Name</label>
							<div class="col-md-8">
								<sf:input type="text" path="name" class="form-control"
									placeholder="Enter Product Name" />
								<sf:errors path="name" cssClass="help-block" element="em" />
							</div>
						</div>


						<div class="form-group">
							<label class="contol-label col-md-4">Brand</label>
							<div class="col-md-8">
								<sf:input type="text" path="brand" class="form-control"
									placeholder="Enter Brand Name" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="contol-label col-md-4">Description</label>
							<div class="col-md-8">
								<sf:textarea type="text" path="description" class="form-control"
									placeholder="Description Of Product" />
								<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="contol-label col-md-4">Unit price</label>
							<div class="col-md-8">
								<sf:input type="number" path="unitPrice" class="form-control"
									placeholder="Enter Price " />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="contol-label col-md-4">Quantity</label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" class="form-control"
									placeholder="Enter Quantity " />
								<sf:errors path="quantity" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="contol-label col-md-4">Select Category</label>
							<div class="col-md-8">
								<sf:select path="categoryId" items="${categories}"
									itemLabel="name" itemValue="id" class="form-control" />

							</div>
						</div>

						<div class="text-right">
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="active" />
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-4">
								<input type="submit" class="btn btn-primary" value="Submit"
									name="submit" />
							</div>
						</div>
					</sf:form>

				</div>

			</div>

		</div>

	</div>

</div>

