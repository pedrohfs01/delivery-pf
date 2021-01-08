import { useEffect, useState } from 'react';
import { fetchProducts } from '../api';
import OrderLocation from './OrderLocation';
import ProductsList from './ProductsList';
import StepHeader from './StepsHeader';
import './styles.css';
import { OrderLocationData, Product } from './types';

function Orders(){
    const [products, setProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {
        fetchProducts()
        .then(response => setProducts(response.data))
        .catch(error => console.log(error))
    }, []);

    return(
        <div className="orders-container">
            <StepHeader></StepHeader>
            <ProductsList products={products}></ProductsList>
            <OrderLocation onChangeLocation={location => setOrderLocation(location)}></OrderLocation>
        </div>
    );
}

export default Orders;