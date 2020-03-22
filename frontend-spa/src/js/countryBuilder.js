import{
    displayCountries
} from './countriesPage.js'

const getAllCountries = () => {
    fetch('http://localhost:8080/countries/')
        .then(response => response.json())
        .then(countryJson => displayCountries(countryJson));
}

getAllCountries();

export{
    getAllCountries
}