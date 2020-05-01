import * as React from 'react';
import ProductSelection from "./ProductSelection";


export class ProductList extends React.PureComponent {
	render() {
		return (
			<div>
				ProductList

				<ProductSelection  products={this.props.products}/>



				<div>Right side

					<div>Right
						side
					</div>



				</div>



			</div>
		);
	}
}

export default ProductList;
