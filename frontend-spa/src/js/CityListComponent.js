import {
    renderCityView
} from './CityComponent.js'

const appendCityList = (cities, element) => {
    const cityList = document.createElement('ul');
    cities.forEach(city => {
        const cityName = document.createElement('li');
        cityName.innerText = city.name;
        cityName.addEventListener('click', () => {
            renderCityView(city.id)
        });
        cityList.appendChild(cityList);
    });
    element.appendChild(cityList);
}

export {
    appendCityList
}