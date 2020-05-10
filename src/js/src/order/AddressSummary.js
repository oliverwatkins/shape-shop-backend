import * as React from 'react';
import type {Address} from "../AppState";


type Props = {
	address: Address
}

export function AddressSummary(props: Props) {

	// alert("props " + JSON.stringify(props))
	let style = {
		background: "white",
		width: 500
	}
	let styleTD = {
		padding: "5px 9px 12px 23px"
	}
	return (
		<div style={style}>
			{props.address &&
			<div>
				Name: {props.address.name}
				Street: {props.address.street}
				Postcpde: {props.address.postcode}
				Email: {props.address.email}
				Telephone: {props.address.telephone}
			</div>
			}
		</div>
	);
}

export default AddressSummary;