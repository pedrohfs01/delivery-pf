import { useEffect, useState } from 'react';
import { fetchProducts } from '../api';
import Footer from '../Footer';
import { checkIsSelected } from './helpers';
import OrderLocation from './OrderLocation';
import OrderSummary from './OrderSummary';
import ProductsList from './ProductsList';
import StepHeader from './StepsHeader';
import './styles.css';
import { OrderLocationData, Product } from './types';

function Orders() {
    const [products, setProducts] = useState<Product[]>([]);
    const [selectedProducts, setSelectedProducts] = useState<Product[]>([]);
    const [orderLocation, setOrderLocation] = useState<OrderLocationData>();

    useEffect(() => {
        fetchProducts()
            .then(response => setProducts(response.data))
            .catch(error => console.log(error))
    }, []);

    const handleSelectProduct = (product: Product) => {
        const isAlreadySelected = checkIsSelected(selectedProducts, product)
      
        if (isAlreadySelected) {
          const selected = selectedProducts.filter(item => item.id !== product.id);
          setSelectedProducts(selected);
        } else {
          setSelectedProducts(previous => [...previous, product]);
        }
      }

    return (
        <>
            <div className="orders-container">
                <StepHeader></StepHeader>
                <ProductsList 
                products={products}
                onSelectProduct={handleSelectProduct}
                selectedProducts={selectedProducts}
                ></ProductsList>
                <OrderLocation onChangeLocation={location => setOrderLocation(location)}></OrderLocation>
                <OrderSummary></OrderSummary>
            </div>

            <Footer></Footer>
        </>
    );
}

export default Orders;