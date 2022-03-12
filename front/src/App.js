import './App.css';
import React, { Component } from 'react';

import Form from './components/Form';
import Phones from './components/Phones';

class App extends Component {
	/**
	 * What we usually do to create a method inside a class component (before React 16):
	 * constructor () {
	 * 	this.getPhone = this.getPhone.bind();
	 * }
	 * getPhone() {
	 * 
	 * }
	 * We don't need to to this anymore
	 */
	state = {
		phones: []
	}

	getPhone = async (e) => { //To use this method I have to pass it as props to the component who needs it
		const phoneName = e.target.elements.phoneName.value;
		e.preventDefault();
		console.log(phoneName); //To see this on the console we have to prefent default beahviour of the page, which is refreshing

		const api_call = await fetch('http://localhost:8080/phones');

		const data = await api_call.json();
		this.setState({ phones: data.phones})
	}

	componentDidUpdate = () => {
		const json = localStorage.getItem("phones");
		const phones = JSON.parse(json);
		this.setState({ phones });
	}

	componentDidMount = () => {
		const phones = JSON.stringify(this.state.phones);
		localStorage.setItem("phones", phones);
	}

	render() {
		return (
			<div className="App">
				<header className="App-header">
					<h1 className="App-title">Phone Catalog</h1>
				</header>
				<Form getPhone={this.getPhone} />
				<Phones phones={this.state.phones} />
			</div>
		);
	}
}

export default App;
