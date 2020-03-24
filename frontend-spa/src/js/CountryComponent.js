import {
    appendCityList
} from './CityListComponent.js'

import {
    renderCountries
} from './CountriesComponent.js';

const renderCountry = (countryId) => {
    const countryElement = document.querySelector('main');
    countryElement.innerHTML = '';
    fetch(`http://localhost:8080/countries/${countryId}/`)
        .then(response => response.json())
        .then(country => createCountryView(country))
        .then(countryView => countryElement.appendChild(countryView))
        .catch(err => console.error(err));
        console.log("renderCountry")
}

const createCountryView = (country) => {
    const countryView = document.createElement('section');
    appendCountryName(country, countryView);
    appendCityList(country.cities, countryView);
    appendReturnToCountriesLink(countryView);
   console.log("createCountryView")
    return countryView;
}

const appendCountryName = (country, element) => {
    const countryName = document.createElement('h2');
    countryName.innerText = country.name;
    element.appendChild(countryName);
    console.log("appendCountryName")
}

const appendReturnToCountriesLink = (element) => {
    const returnToCountriesLink = document.createElement('a');
    returnToCountriesLink.innerText = "Return to a listing of all countries."
    returnToCountriesLink.addEventListener('click', (event) => {
        event.preventDefault();
        renderCountries();
    });
    element.appendChild(returnToCountriesLink);
    console.log("appendReturntoCountriesLink")
}

export {
    renderCountry
}