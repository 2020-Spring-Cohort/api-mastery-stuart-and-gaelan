import{
    DomMaker
} from './DomMaker.js'
import{
    createNewCountryForm
} from './newCountryForm.js'

const anchorElement = document.querySelector('.anchor');

const displayCountries = (countries) => {
    anchorElement.innerHTML='';
    let countryList = new DomMaker('ul')
        .changeContent('List of countries');

    countries.forEach((country) =>{
        countryList.appendChild(new DomMaker('li')
        .changeContent(country.name)
        .render())
    });

    anchorElement.append(countryList.render());
    anchorElement.append(createNewCountryForm());
}

export{
    displayCountries
}