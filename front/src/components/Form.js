import React from "react";

/**
 * As this is a stateless functional component we cannot use this.getPhone to access its props
 * We hace to pass it as param (props).
 * props is an object so in order to access its attributes we use props.whatever
 * 
 */
const Form = props => (//Stateless functional component because it doesn't need state
	<form onSubmit={props.getPhone}>
		<input className="form__input" type="text" name="phoneName"/>
		<button className="form__button">Search</button>
	</form>
);

export default Form;