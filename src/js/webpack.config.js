let debug = process.env.NODE_ENV !== "production";
let webpack = require('webpack');
let path = require('path');

const HtmlWebPackPlugin = require("html-webpack-plugin");
const FlowWebpackPlugin = require('flow-webpack-plugin')


module.exports = {
	context: path.join(__dirname, "src"),
	devtool: debug ? "inline-sourcemap" : null,
	entry: "./client.js",
	output: {
		path: __dirname + "/src/dist/",
		filename: "client.min.js"
	},
	module: {
		rules: [
			{
				test: /\.(js|jsx)$/,
				exclude: /node_modules/,
				use: {
					loader: "babel-loader"
				}
			},
			{
				test: /\.html$/,
				use: [
					{
						loader: "html-loader"
					}
				]
			},
			{
				test: /\.css|\.scss$/,
				loaders: ["style-loader", "css-loader", "sass-loader"]
			},
			{
				test: /\.(png|jpe?g|gif)$/i,
				use: [
					{
						loader: 'url-loader',
					},
				],
			}
		]
	},
	devServer: {
		publicPath: "/",
		contentBase: "./public",
		hot: true
	},
	plugins: debug ? [] : [
		new webpack.optimize.DedupePlugin(),
		new webpack.optimize.OccurenceOrderPlugin(),
		new webpack.optimize.UglifyJsPlugin({mangle: false, sourcemap: false}),
		new HtmlWebPackPlugin({
			template: "./src/index.html",
			filename: "./index.html"
		}),

		// "@babel/plugin-proposal-class-properties",


		new FlowWebpackPlugin(),
	],
};