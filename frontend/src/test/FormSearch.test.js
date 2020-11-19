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
        expect(wrapper.find('[name="minprice"]')).toHaveLength(1);
        expect(wrapper.find('[name="maxprice"]')).toHaveLength(1);
        expect(wrapper.find('[name="startDate"]')).toHaveLength(1);
        expect(wrapper.find('[name="endDate"]')).toHaveLength(1);

    });

    test('should run onChange with the new state', () => {
        const dateTest = new Date();
        const updateFilter = jest.fn();
        const wrapper = shallow(<FormSearch onFilterChange={updateFilter}/>);
        wrapper.find('select[name="guests"]').simulate('change', {target:{name:'guests', value: '3'}});
        wrapper.find('select[name="minprice"]').simulate('change', {target:{name:'minprice', value: '50'}});
        wrapper.find('select[name="maxprice"]').simulate('change', {target:{name:'maxprice', value: '200'}});
        wrapper.find('select[name="type"]').simulate('change', {target:{name:'type', value: '2'}});
        wrapper.find('form').simulate('submit', {preventDefault: () => {}});       

        expect (updateFilter).toHaveBeenCalledWith({
                rtypes: [],
                guests: "3",
                startDate: dateTest,
                endDate: dateTest,
                type: "2",
                minprice: "50",
                maxprice: "200"
        })
    });

});