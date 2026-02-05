import {expect, test} from "@playwright/test";

test.describe('ATM Page Tests', () => {

    //
    test('sidan går att nå', async ({page}) => {
        //namn på test och start en browser
        await page.goto('http://localhost:8081/atm')
        //gå till denna sida
        await expect(page).toHaveURL('http://localhost:8081/atm');
        //controller att vi kom till våran sida

    });

    test('sidan laddas korrekt', async ({page}) => {
        await page.goto('http://localhost:8081/atm')

        const heading = page.locator('h1');
        //hittar våran h1 i atm.html som ser ut såhär <h1>ATM</h1>
        await expect(heading).toHaveText('ATM')
        //kontrollerar att att det står ATM i h1 raden. Om detta lyckas har html koden laddats.

    });

    test('saldot visas korrekt i HTML-mallen', async ({page}) => {
        await page.goto('http://localhost:8081/atm')

        const balance = page.locator('span');
        await expect(balance).toHaveText('0')
    });


});