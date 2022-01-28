## Android Profiler Performance Test

### Scenario Test TC-1
![ScreenShoot Apps](https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/scenario-test-1.png?raw=true)

### Scenario Test TC-2
![ScreenShoot Apps](https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/scenario-test-2.png?raw=true)

### Step by Step Profiler Performance Test
- Kondisi Apps : Consume Library
- Membuat 2 Activity, MainActivity dan DetailActivity
- Pada MainActivity di buat request data dari API Server
- Kemudian di check menggunakan profiler

### Specification Device Test (Android Phone)
Using 2 Android Phone (Redmi Note 10 5G - Xiaomi M2103K19G) and (Oppo CPH1729)

- Redmi Note 10 5G - Xiaomi M2103K19G
<table>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>1.</td>
        <td>Device Name</td>
        <td>Redmi Note 10 5G - Xiaomi M2103K19G</td>
    </tr>
    <tr>
        <td>2.</td>
        <td>Android Version</td>
        <td>11</td>
    </tr>
    <tr>
        <td>3.</td>
        <td>RAM</td>
        <td>4.00 GB</td>
    </tr>
    <tr>
        <td>4.</td>
        <td>CPU - Processor</td>
        <td>Octa-core Max2.2GHz</td>
    </tr>
    <tr>
        <td>5.</td>
        <td>Internal Storage</td>
        <td>128 GB</td>
    </tr>
</table>

- Oppo CPH1729

<table>
    <tr>
        <th>No.</th>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <tr>
        <td>1.</td>
        <td>Device Name</td>
        <td>Oppo CPH1729</td>
    </tr>
    <tr>
        <td>2.</td>
        <td>Android Version</td>
        <td>7.1.1</td>
    </tr>
    <tr>
        <td>3.</td>
        <td>RAM</td>
        <td>3.00 GB</td>
    </tr>
    <tr>
        <td>4.</td>
        <td>CPU - Processor</td>
        <td>Octa-core</td>
    </tr>
    <tr>
        <td>5.</td>
        <td>Internal Storage</td>
        <td>32 GB</td>
    </tr>
</table>

### Test Case

- Test Case 1 (TC-1)
    - TC-1-A : Menampilkan Daftar Item
    - TC-1-B : Pilih item dari daftar yang di tampilkan

- Test Case 2 (TC-2)
    - TC-2-A : Mencari daftar item dengan keyword "vitamin"
    - TC-2-B : Pilih item dari daftar yang di tampilkan

### Result

- Profiler Test Case 1 (TC-1) [more details](https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-1)

<table>
    <tr>
        <th><a href="https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-1/redmi-note-10-5G">Redmi Note 10 5G - Xiaomi M2103K19G</a></th>
        <th><a href="https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-1/oppo-CPH1729">Oppo CPH1729</a></th>
    </tr>
    <tr>
        <td><img src="https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/result-profiler-test-case-1/redmi-note-10-5G/test-case-1-all-general.png"></td>
        <td><img src="https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/result-profiler-test-case-1/oppo-CPH1729/test-case-1-all-general.png"></td>
    </tr>
</table>

- Profiler Test Case 2 (TC-2) [more details](https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-2)

<table>
    <tr>
        <th><a href="https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-2/redmi-note-10-5G">Redmi Note 10 5G - Xiaomi M2103K19G</a></th>
        <th><a href="https://github.com/amirisback/nutrition-framework/tree/master/docs/scenario-test/result-profiler-test-case-2/oppo-CPH1729">Oppo CPH1729</a></th>
    </tr>
    <tr>
        <td><img src="https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/result-profiler-test-case-2/redmi-note-10-5G/test-case-2-all-general.png"></td>
        <td><img src="https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/result-profiler-test-case-2/oppo-CPH1729/test-case-2-all-general.png"></td>
    </tr>
</table>

- Profiler Performance Test Resume [Click Here For Full Report](https://github.com/amirisback/nutrition-framework/blob/master/docs/scenario-test/report-profiler-test.xlsx?raw=true)
<table>
	<tr>
        <th>No</th>
        <th>Device</th>
        <th>Test Case</th>
        <th>CPU Usage</th>
        <th>Memory Usage</th>
        <th>Network Usage Send</th>
        <th>Network Usage Received</th>
        <th>Energy Usage</th>
        <th>Execution Time</th>
    </tr>
    <tr>
        <td>1</td> <!-- No -->
        <td>Redmi Note 10 5G</td> <!-- Device -->
        <td>TC-1-A</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>2</td> <!-- No -->
        <td>Redmi Note 10 5G</td> <!-- Device -->
        <td>TC-1-B</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>3</td> <!-- No -->
        <td>Redmi Note 10 5G</td> <!-- Device -->
        <td>TC-2-A</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>4</td> <!-- No -->
        <td>Redmi Note 10 5G</td> <!-- Device -->
        <td>TC-2-B</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>5</td> <!-- No -->
        <td>Oppo CPH1729</td> <!-- Device -->
        <td>TC-1-A</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>6</td> <!-- No -->
        <td>Oppo CPH1729</td> <!-- Device -->
        <td>TC-1-B</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>7</td> <!-- No -->
        <td>Oppo CPH1729</td> <!-- Device -->
        <td>TC-2-A</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
    <tr>
        <td>8</td> <!-- No -->
        <td>Oppo CPH1729</td> <!-- Device -->
        <td>TC-2-B</td> <!-- Test Case -->
        <td></td> <!-- CPU Usage -->
        <td></td> <!-- Memory Usage -->
        <td></td> <!-- Network Usage Send -->
        <td></td> <!-- Network Usage Received -->
        <td></td> <!-- Energy Usage -->
        <td></td> <!-- Execution Time -->
    </tr>
</table>

- Photo Documentation Test
![ScreenShoot Apps](https://raw.githubusercontent.com/amirisback/nutrition-framework/master/docs/scenario-test/doing-testing.jpeg?raw=true)
