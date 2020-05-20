import * as React from 'react';
import ProductSelection from "./ProductSelection";
import OrderSummary from "./OrderSummary";


import {wizardPages as pages} from "./OrderWizard"
import {NextButton} from "./NextButton";
import type {Product} from "../AppState";

type Props = {
	productItems: Array<Product>,
	selectedProducts: Array<Product>,
}

//redundant
export class ProductList extends React.PureComponent<Props> {
	render() {
		return (
			<div>

				<div style={{display: "flex"}} className="wizardPanel">

					<ProductSelection productItems={this.props.productItems}/>
					<div style={{textAlign: "right"}}>
						<NextButton label={"NEXT"} page={pages.DRINK_LIST}/>
						<OrderSummary selectedProducts={this.props.selectedProducts}/>
					</div>
				</div>
			</div>
		);
	}
}

export default ProductList;
