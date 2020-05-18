import * as React from 'react';
import ProductSelection from "./ProductSelection";
import OrderSummary from "./OrderSummary";


import {wizardPages as pages} from "./OrderWizard"
import {NextButton} from "./NextButton";

type Props = {
	products: [],
	selectedProducts: [],
}

//redundant
export class ProductList extends React.PureComponent<Props> {
	render() {
		return (
			<div>

				<div style={{display: "flex"}} className="wizardPanel">

					<ProductSelection products={this.props.products}/>
					<div style={{textAlign: "right"}}>
						<NextButton label={"NEXT"} page={pages.ADDRESS}/>
						<OrderSummary selectedProducts={this.props.selectedProducts}/>
					</div>
				</div>
			</div>
		);
	}
}

export default ProductList;
