
import * as React from 'react';
import ProductSelection from "./ProductSelection";
import SideSummary from "./SideSummary";
import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faArrowCircleRight, faArrowCircleLeft} from "@fortawesome/free-solid-svg-icons";


//redundant
export class Address extends React.PureComponent {
	render() {
		return (
			<div style={{display:"flex"}}>

				<Link to="/order/productlist">
					<FontAwesomeIcon icon={faArrowCircleLeft} style={{fontSize:"100px", color:"gray"}} />
				</Link>

				Address

				<div className={"aside"}>
					<Link to="/welcome">
						<FontAwesomeIcon icon={faArrowCircleRight} style={{fontSize:"100px", color:"gray"}} />
					</Link>
				</div>
			</div>
		);
	}
}
export default Address;

