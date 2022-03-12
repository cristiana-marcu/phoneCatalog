import './App.css';
import React, { Component } from 'react';

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
		phones: [],
		loading: false
	}

	getPhone = async (e) => {
		const phoneName = e.target.elements.phoneName.value;
		e.preventDefault();

		const api_call = await fetch('http://localhost:8080/phones');

		const data = api_call.json();
		console.log(data);
		this.setState({ phones: data});
	}

	componentDidMount() {
		this.setState({ loading: true });
		fetch('http://localhost:8080/phones')
		.then(response => response.json())
		.then(data => this.setState({ phones: data, loading: false }));
	}

	render() {
		console.log(this.state.phones);
		console.log(this.state.loading);
		return (
			<div className="App">
				<header className="App-header">
					<h1 className="App-title">Phone Catalog</h1>
				</header>
				<Phones phones={this.state.phones} />
			</div>
		);
	}
}

export default App;
