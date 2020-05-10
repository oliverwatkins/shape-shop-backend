import * as React from 'react';
import ProductSelection from "./ProductSelection";
import OrderSummary from "./OrderSummary";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight} from "@fortawesome/free-solid-svg-icons";


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
			<div style={{display: "flex"}} className="wizardPanel">
				<ProductSelection products={this.props.products}/>
				<div>
					<OrderSummary selectedProducts={this.props.selectedProducts}/>

					<NextButton label={"NEXT"} page={pages.ADDRESS}/>
				</div>
			</div>
		);
	}
}

export default ProductList;
