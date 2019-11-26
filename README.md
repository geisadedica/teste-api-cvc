# API Rest - TESTE
> API para intermediar o acesso entre nosso front-end e o broker.

## Exemplo de uso

Urls disponiveis:

1)Consulta hoteis e taxas de hospedagem por cidade:
{server}/v1/hotels/load/{cityCode}/{checkin}/{checkout}/{adults}/{childs}

onde: 
{server} - qualquer servidor/container onde a aplicação foi instalada.
{cityCode} - codigo da cidade
{checkin} - data do checkin (formato MM-dd-yyyy)
{checkout} - data do checkout (formato MM-dd-yyyy)
{adults} - número de adultos
{childs} - número de crianças

2)Consulta detalhe do Hotel:
{server}/v1/hotels/load/detail/{idHotel}
onde: 
{server} - qualquer servidor/container onde a aplicação foi instalada
{idHotel} - codigo do hotel
