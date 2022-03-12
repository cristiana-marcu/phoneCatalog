import React from "react";

const Phones = props => (
	<div className="container">
		<div className="row">
			{ props.phones.map((phone) => {
				return (
					<div className="col-md-4">
						<div className="phones__box">
							<img className="phone__box-img" src="https://store-images.s-microsoft.com/image/apps.46116.70628353720390187.c5ec2284-1a6e-4ed0-a094-b54b14b8d466.f01d3b8d-41e1-42bc-b322-443ee5b1f390?q=90&w=480&h=270" alt="goat" />
							<div className="phone__text">
								<h5 className="phones__title"> Just a goat, soon a phone</h5>
								<p className="phones__subtitle">RAM: <span>from api</span></p>
							</div>	
							<button className="phone_buttons">Details</button>
						</div>
					</div>
				);
			})}
		</div>
	</div>
);

export default Phones;