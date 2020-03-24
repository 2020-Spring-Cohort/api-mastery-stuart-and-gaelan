import {
    renderCountries
} from './CountriesComponent.js'

const renderHomeView = () => {
    const anchor = document.querySelector('.anchor');
    
    anchor.appendChild(document.createElement('main'));
    renderCountries();
}

renderHomeView();