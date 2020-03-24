import {
    renderCountry
} from './CountryComponent.js'

const renderCityView = (cityId) => {
    const cityElement = document.querySelector('main');
    cityElement.innerHTML = '';
    fetch(`http://localhost:8080/cities/${id}/`)
        .then(response => response.json())
        .then(city => createCityView(city))
        .then(cityView => cityElement.appendChild(cityView))
        .catch(err => console.error(err));
        console.log("renderCityView")
}

const createCityView = (city) => {
    const cityView = document.createElement('section');
    appendCityName(city, cityView);
    appendReturnToCountryLink(city, cityView);
    console.log("createCityView")
    return cityView;
}

const appendCityName = (city, element) => {
    const cityName = document.createElement('h2');
    cityName.innerText = city.name;
    element.appendChild(cityName);
    console.log("appendCityName")
}

const appendReturnToCountryLink = (city, element) => {
    const countryLink = document.createElement('a');
    fetch(`http://localhost:8080/countries/${city.id}/country/`)
        .then(response => response.json())
        .then(country => {
            countryLink.innerText = `Return to ${country.name}.`
            countryLink.addEventListener('click', (event) => {
                event.preventDefault();
                renderCountry(country.id);
            })
            element.appendChild(countryLink);
        })
        .catch(err => console.error(err));
        console.log("appendReturnToCountryLink")
}

export {
    renderCityView
}