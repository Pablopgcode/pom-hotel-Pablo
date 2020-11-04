import React from 'react';
import FormSearch from 'components/Forms/FormSearch';
import {shallow} from 'enzyme';
import {now} from '../services/dateservice';

describe('Search form unit test', () => {
    test('it should render without crash', () => {
        const wrapper = shallow(<FormSearch />);
        expect(wrapper).toMatchSnapshot(); 
    });

    test('should have required inputs [',() => {
        const wrapper = shallow(<FormSearch />);
        expect(wrapper.find('[name="guests"]')).toHaveLength(1);
    });

    test('should run onChange with the new state', () => {
        const updateFilter = jest.fn();
        const wrapper = shallow(<FormSearch onFilterChange={updateFilter}/>);
        wrapper.find('select[name="guests"]').simulate('change', {target:{name:'guests', value: '3'}});
        wrapper.find('form').simulate('submit', {preventDefault: () => {}});


        expect (updateFilter).toHaveBeenCalledWith({
                rtypes: [],
                guests: "3",
                startDate: now,
                endDate: now,
                type: "",
                minprice: "1",
                maxprice: "1000"
        })
    });

});