import {
    renderCountry
} from './CountryComponent.js'

const renderCountries = () => {
    const countriesElement = document.querySelector('main');
    countriesElement.innerHTML = '';
    fetch('http://localhost:8080/countries/')
        .then(response => response.json())
        .then(countries => {
            const countriesList = document.createElement('ul');
            countries.forEach(country => {
                const countryListing = document.createElement('li');
                countryListing.innerText = country.name;
                countryListing.addEventListener('click', () => {
                    renderCountry(country.id);
                });
                countriesList.appendChild(countryListing);
            });
            countriesElement.appendChild(countriesList);
        })
        .catch(err => console.error(err));
    return countriesElement;
}

export {
    renderCountries
}